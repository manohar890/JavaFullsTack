import React, { useEffect, useState } from "react";
import ProductList from "./ProductsList";
import axios from "axios";
export default function Products (props){
   let [products,setProducts]= useState([]);
   const fetchData = async () => {
           await fetch("http://localhost:3001/productData")
              .then(response => {
                return response.json()
              })
              .then(data => {
                setProducts(data)
              })
          }
    useEffect (  ()=>{
       fetchData()
         },[]);
        return(
            <div>
                <ProductList pro={products} />
            </div>
        )
    }
