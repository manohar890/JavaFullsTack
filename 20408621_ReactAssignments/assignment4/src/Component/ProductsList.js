import React from "react";
import Product from "./Product";
export default class ProductList extends React.Component {
    render () {
      let productNodes = this.props.pro.map(product => (
          <Product id={product.id} name={product.productName}  price={product.productPrice} quantity={product.productQuantity} />
      ));
      return (
        <div style={{marginLeft:'300px'}}>
        <h1 >Products : </h1>
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
          <a href="/addProduct" className="btn btn-success" style={{marginTop:20}}>AddProduct</a>
        </div>
      );
    }
  }
  