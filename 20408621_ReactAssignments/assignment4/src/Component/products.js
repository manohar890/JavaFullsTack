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
        axios.get("http://localhost:3001/productData").then(obj=>{
        const da=obj.data;
        this.setState({products: da })
    })
}
    render(){
        return(
            <div>
                <ProductList pro={this.state.products} />
            </div>
        )
    }
}