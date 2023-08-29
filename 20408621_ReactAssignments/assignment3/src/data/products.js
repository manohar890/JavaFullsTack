import React from "react";
import ProductList from "./ProductsList";
import axios from "axios";
export default class Products extends React.Component{
    constructor(props){
        super(props);
        this.state={
            products:[]
        }
    }
    componentDidMount() {
        //this.setState({ products : db.productsData });
        axios.get("https://localhost:3000/products").then(obj=>{
        const da=obj.data;
        this.setState({products: da })
    }
        )
    }
    render(){
        return(
            <div>
                <ProductList pro={this.state.products} />
            </div>
        )
    }
}