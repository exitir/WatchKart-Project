package com.turvoassignment.ecommerce.wristwatch.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.turvoassignment.ecommerce.wristwatch.models.Cart;
import com.turvoassignment.ecommerce.wristwatch.models.CartEntry;
import com.turvoassignment.ecommerce.wristwatch.models.OrderStatusEnum;
import com.turvoassignment.ecommerce.wristwatch.models.WatchRequestWrapper;
import com.turvoassignment.ecommerce.wristwatch.requests.FlashSalePurchaseServiceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.turvoassignment.ecommerce.wristwatch.exceptions.WatchKartDaoServiceGenericException;
import com.turvoassignment.ecommerce.wristwatch.models.FlashRegisteredUser;
import com.turvoassignment.ecommerce.wristwatch.models.FlashSale;
import com.turvoassignment.ecommerce.wristwatch.models.PurchaseOrder;
import com.turvoassignment.ecommerce.wristwatch.models.User;
import com.turvoassignment.ecommerce.wristwatch.models.Watch;
import com.turvoassignment.ecommerce.wristwatch.models.WatchKart;

@Component
public class WatchKartDaoService {
    private static Logger logger = LoggerFactory.getLogger(WatchKartDaoService.class);

    private WatchKart watchKartCompany;

    public WatchKart getWatchKart() {
        if (watchKartCompany == null) {
            watchKartCompany = WatchKart.getWatchKartInstance();
        }

        // hardcoding few initial user and watches and flashsale
        return watchKartCompany;
    }

    public void registerFlashUser(String userId, String flashSaleId) {
        if (flashSaleId == null || userId == null) {
            throw new WatchKartDaoServiceGenericException(
                    "flashSaleId or user cannot be null to register for flash sale.");
        }
        watchKartCompany = getWatchKart();
        FlashSale flashSale = getFlashSale(flashSaleId);
        if (flashSale == null) {
            throw new WatchKartDaoServiceGenericException("There are no flash sale active currently.");
        }
        List<String> registeredUsersIds = flashSale.getRegisteredUserIds();
        if (registeredUsersIds == null) {
            registeredUsersIds = new ArrayList<String>();
            flashSale.setRegisteredUserIds(registeredUsersIds);

        } else {
            for (String uid : registeredUsersIds) {
                if (uid.equals(userId)) {
                    throw new WatchKartDaoServiceGenericException(
                            String.format("User: %s is already regisgtered for flashsale: %s", userId, flashSaleId));
                }
            }
        }
        registeredUsersIds.add(userId);

        logger.info("user: {} is successfully registered for flashsale: {}", userId, flashSaleId);
    }

    public FlashSale getFlashSale(String flashSaleId) { // will return the flashSale obj from flashsaleId
        for (FlashSale f : watchKartCompany.getFlashSales()) {
            if (f.getFlashSaleId().equals(flashSaleId)) {
                return f;
            }
        }
        return null;
    }

    public boolean checkIfUserRegisteredForFlashSale(String userId, String flashSaleId) {
        WatchKart wk = WatchKart.getWatchKartInstance();
        boolean flashSaleExists = false;
        boolean userRegistered = false;
        List<FlashSale> flashSales = wk.getFlashSales();
        if (flashSales == null || flashSales.isEmpty()) {
            throw new WatchKartDaoServiceGenericException("Currently there are no active flash sales.");
        }
        flashSaleExists = true;
        for (FlashSale fs : flashSales) {
            if (fs.getFlashSaleId().equals(flashSaleId)) {
                flashSaleExists = true;
                if (fs.getRegisteredUserIds() == null) {
                    throw new WatchKartDaoServiceGenericException(
                            String.format("Currently there are no users registered for flashsale: %s", flashSaleId));
                }
                for (String uid : fs.getRegisteredUserIds()) {
                    if (uid.equals(userId)) {
                        userRegistered = true;
                    }
                }
            }
        }

        if (!flashSaleExists) {
            throw new WatchKartDaoServiceGenericException(
                    String.format("The user: %s has not yet registered for flashsale: %Id", userId, flashSaleId));
        } else {
            if (userRegistered) {
                return true;
            } else {
                return false;
            }
        }
    }

    public List<Watch> getAllWatchesOnFlashSales(String flashSaleId) {
        WatchKart wk = WatchKart.getWatchKartInstance();
        List<String> watchIdsOnSale = new ArrayList();
        boolean validFlashSaleId = false;
        for (FlashSale fs : wk.getFlashSales()) {
            if (fs.getFlashSaleId().equals(flashSaleId)) {
                validFlashSaleId = true;
                watchIdsOnSale = fs.getWatchIdsOnSale();
                break;
            }
        }
        if (!validFlashSaleId) {
            return null;
        }

        List<Watch> watchesOnFlashSale = new ArrayList<Watch>();
        if (!watchIdsOnSale.isEmpty()) {
            for (String watchId : watchIdsOnSale) {
                for (Watch w : wk.getWatchs()) {
                    if (w.getWatchId().equals(watchId)) {
                        watchesOnFlashSale.add(w);
                    }
                }
            }
        }

        return watchesOnFlashSale;
    }

    public WatchKart peekWatchKart(String userId) {
        User user = null;
        for (User u : WatchKart.getWatchKartInstance().getUsers()) {
            if (u.getUserid().equals(userId)) {
                user = u;
            }
        }
        if (user == null) {
            throw new WatchKartDaoServiceGenericException(String.format("Could not find any user details with userId: %s ", userId));
        }
        if (!user.isAdminUser()) {
            throw new WatchKartDaoServiceGenericException(String.format("Only admin user can peek at the WatchKart, user %s is not an admin user", userId));
        }
        return getWatchKart();
    }


    public PurchaseOrder createPurchaseOrder(FlashSalePurchaseServiceRequest request) {
        PurchaseOrder po = new PurchaseOrder();
        po.setUserId(request.getUserId());
        po.setOrderStatus(OrderStatusEnum.INITIATED);
        po.setCart(createCart(request.getWatchesWithQty(), request.getFlashSaleId()));
        po.setOrderBillingAmount(po.getCart().getCartAmount());
        po.setOrderId(request.getUserId() + new Date().getTime());// orderId = userid + timeinmillisecond

        getWatchKart().getPurchaseOrders().add(po); // adding the purchaseorder to WatchKart
        addPurchaseOrderToUserData(po, request.getUserId());// adding the purchaseorder to the user

        return po;
    }

    private void addPurchaseOrderToUserData(PurchaseOrder po, String userId) {
        for (User u : getWatchKart().getUsers()) {
            if (u.getUserid().equals(userId)) {
                List<PurchaseOrder> purchaseOrders = u.getPurchaseOrders();
                if (purchaseOrders == null) {
                    purchaseOrders = new ArrayList<PurchaseOrder>();
                }
                purchaseOrders.add(po);
                break;
            }
        }
    }

    private Cart createCart(List<WatchRequestWrapper> watchesWithQty, String flashId) {
        Cart cart = new Cart();
        List<CartEntry> cartEntries = new ArrayList<CartEntry>();
        for (WatchRequestWrapper wr : watchesWithQty) {
            if (!checkIfWatchOnFlashSale(wr.getWatchId(), flashId)) { // check if watch id is on sale or not
                continue;
            }
            Watch watch = getWatchFromWatchId(wr.getWatchId());
            if (watch != null) {
                CartEntry ce = new CartEntry();
                ce.setWatch(watch);
                ce.setQuantity(wr.getQuantity());
                cartEntries.add(ce);
            }

        }
        cart.setCartEntries(cartEntries);
        return cart;
    }

    private boolean checkIfWatchOnFlashSale(String watchId, String flashId) {
        for (FlashSale f : getWatchKart().getFlashSales()) {
            if (f.getFlashSaleId().equals(flashId)) {
                for (String wid : f.getWatchIdsOnSale()) {
                    if (wid.equals(watchId)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private Watch getWatchFromWatchId(String watchId) {
        for (Watch w : getWatchKart().getWatchs()) {
            if (w.getWatchId().equals(watchId)) {
                return w;
            }
        }
        return null;
    }
}
