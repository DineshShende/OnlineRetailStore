package com.store.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.store.entity.Bill;
import com.store.entity.BillItem;
import com.store.entity.Product;
import com.store.repository.BillRepository;
import com.store.service.BillDetailsService;

/**
 * The Class BillDetailsServiceImpl.
 *
 * @author Dinesh Shende
 * @version 1.0
 * @since 21 Mar, 2019
 */
@Component
public class BillDetailsServiceImpl implements BillDetailsService {

    /** The bill repository. */
    @Autowired
    BillRepository billRepository;

    /**
     * {@inheritDoc}
     * <p>
     * This specific implementation .
     */
    @Override
    public Bill intializeBill() {
        Bill bill = new Bill();
        bill.setBillDate(new Date());

        Bill savedBill = billRepository.save(bill);

        return savedBill;
    }

    @Override
    public Bill addProduct(Bill bill, Product product, Integer quantity) {

        BillItem billItem = null;

        billItem = computeBillItem(bill, product, quantity, billItem);

        if (bill.getBillItem() != null)
            bill.getBillItem().add(billItem);
        else {
            List<BillItem> newBillItem = new ArrayList<BillItem>();
            newBillItem.add(billItem);
            bill.setBillItem(newBillItem);

        }

        Bill savedBill = billRepository.save(bill);

        return savedBill;
    }

    private BillItem computeBillItem(Bill bill, Product product, Integer quantity, BillItem billItem) {

        // Check If particular Product Already added in Bill;
        if (bill.getBillItem() != null) {
            for (BillItem iterBillItem : bill.getBillItem()) {
                if (checkPorudctsEqual(product, iterBillItem))
                    billItem = iterBillItem;
            }
        }

        if (billItem == null)
            billItem = new BillItem(product, quantity, bill);
        else
            billItem.setQuantity(billItem.getQuantity() + quantity);
        return billItem;
    }

    private boolean checkPorudctsEqual(Product product, BillItem iterBillItem) {
        return iterBillItem.getProductId().getProductId().equals(product.getProductId());
    }

}
