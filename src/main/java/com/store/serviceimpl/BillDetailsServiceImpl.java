package com.store.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import com.store.dto.AddProductRequest;
import com.store.dto.BillItemDetails;
import com.store.dto.DetailedBillResponse;
import com.store.dto.ProductIdQuantityDto;
import com.store.dto.ProductType;
import com.store.entity.Bill;
import com.store.entity.BillItem;
import com.store.entity.Product;
import com.store.repository.BillRepository;
import com.store.repository.ProductRepository;
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
    
    @Autowired
    ProductRepository productRepository;

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
    
	@Override
	public DetailedBillResponse handleAddProductRequest(AddProductRequest addProductRequest) {
		
		Bill bill=billRepository.findOne(addProductRequest.getBillId());
		
		if(bill==null)
			throw new ResourceNotFoundException();
		
		if(addProductRequest.getProductIdWithQuantity()!=null)
		{
			for(ProductIdQuantityDto productIdQuantityDto:addProductRequest.getProductIdWithQuantity())
			{
				Product product=productRepository.findOne(productIdQuantityDto.getProductId()) ;
				addProduct(bill, product, productIdQuantityDto.getQuantity());
			}
		}
		
		DetailedBillResponse detailedBillResponse=geneateBill(bill);
		
		return detailedBillResponse;
	}

    
	@Override
	public DetailedBillResponse geneateBill(Bill bill) {

		DetailedBillResponse billResponse=new DetailedBillResponse();
		billResponse.setBillId(bill.getBillId());
		billResponse.setBillDate(bill.getBillDate());
		
		List<BillItemDetails> billItemDetails=new ArrayList<>();
		Float totalAmt=0.0f;
		Float totalTax=0.0f;
		Float grossTotal=0.0f;
		
		if(bill.getBillItem()!=null)
		{
			for(BillItem billItem:bill.getBillItem())
			{
				Float itemTotal=billItem.getProductId().getCost()*billItem.getQuantity();
				Float itemTaxTotal=getProductTax(billItem.getProductId())*billItem.getQuantity();
				Float itemGrossTaxTotal=itemTotal+itemTaxTotal;
				BillItemDetails itemDetails=new BillItemDetails(billItem.getProductId().getProductName(),
									billItem.getQuantity(), itemTotal, itemTaxTotal, itemGrossTaxTotal);
				
				billItemDetails.add(itemDetails);
				totalAmt+=itemTotal;
				totalTax+=itemTaxTotal;
			}
		}
		
		grossTotal=totalAmt+totalTax;
		billResponse.setGrossTotal(grossTotal);
		billResponse.setTotalAmt(totalAmt);
		billResponse.setTotalTax(totalTax);
		billResponse.setBillItem(billItemDetails);
		return billResponse;
	}

    private Float getProductTax(Product product)
    {
    	Float taxValue=0.0f;
    	if(product.getProductType().equals("A"))
    		taxValue=product.getCost()*(ProductType.A.getTaxValue()/100);
    	else if(product.getProductType().equals("B"))
    		taxValue=product.getCost()*(ProductType.B.getTaxValue()/100);
    	else if(product.getProductType().equals("C"))
    		taxValue=product.getCost()*(ProductType.C.getTaxValue()/100);
    	
    	return taxValue;
    	
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
