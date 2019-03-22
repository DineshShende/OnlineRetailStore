# OnlineRetailStore
Online Retail Store Checkout Counter

Steps of action assumed
1. Bill is initialized
2. Products are fetched by their scancode.
3. Products are added in bill and simultaneously details bill will be generated.

API Details
1. Fetch product by scanid
```
Url:/product/getByScanId/1
Method:GET
Response:
{
  "productId": 123,
  "scanCodeId": "SHOES123",
  "cost": 1200.0,
  "productName": "Shoes",
  "productType": "A"
}
```

2. To initialize bill
```
Url:/bill/init
Method:GET
Response:
{
  "billId": 1,
  "billDate": 1553223849772
}
```
3.Add products to Bill that will return detailed bill.
```
Url:/bill/addProduct
Method:POST
Request:
{
  "billId": 1,
  "productIdWithQuantity": [
    {
      "productId": 5,
      "quantity": 2
    }
  ]
}
Response:
{
  "billId": 1,
  "billDate": 1553223960012,
  "billItem": [
    {
      "productName": "Shoes",
      "quantity": 2,
      "itemTotal": 2400.0,
      "itemTax": 240.0,
      "itemGrossTotal": 2640.0
    }
  ],
  "totalAmt": 2400.0,
  "totalTax": 240.0,
  "grossTotal": 2640.0
}
```

