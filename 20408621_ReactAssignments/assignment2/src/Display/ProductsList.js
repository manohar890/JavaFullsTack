import React from "react";
import Product from "./Product";
export default class ProductList extends React.Component {
    render () {
      let productNodes = this.props.pro.map(product => (
          <Product id={product.productId} name={product.productName}  price={product.productPrice} quantity={product.quantity} />
      ));
      return (
        <>
        <h1 >Products : </h1>
          <table>
            <thead>
              <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Product Quantity</th>
              </tr>
            </thead>
            <tbody>
              {productNodes}
            </tbody>
          </table>
        </>
      );
    }
  }
  