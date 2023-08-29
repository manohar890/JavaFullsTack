import React from "react";
import Product from "./Product";
export default function ProductList (props) {
      let productNodes = props.pro.map(product => (
          <Product id={product.id} name={product.productName}  price={product.productPrice} quantity={product.productQuantity} />
      ));
      return (
        <div>
        <h1>Products List (Using functional Components): </h1>
          <table style={{border : '2px'}}>
            <thead>
              <tr>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Product Quantity</th>
              </tr>
            </thead>
            <tbody>
              {productNodes}
            </tbody>
          </table>
        </div>
      );
    }

  