import React from "react";
import Api from "../data/ProductApi";
import ProductList from "./ProductsList";
export default class AllProductsPage extends React.Component{
    constructor(props){
        super(props);
        this.state={
            products:[]
        }
    }
    componentDidMount() {
        this.setState({ products:Api.getAllProducts() });
    }
    render(){
        return(
            <div>
                <ProductList pro={this.state.products} />
            </div>
        )
    }
}