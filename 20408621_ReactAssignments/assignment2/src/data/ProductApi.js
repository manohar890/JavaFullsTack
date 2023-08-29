
import component from "./ProductData";
import React from "react";
export default class Api extends React.Component{
    static getAllProducts(){
        return component.ProductData;
    }
}