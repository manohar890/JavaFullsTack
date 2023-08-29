import React from "react";
import {useNavigate } from "react-router-dom";


export default function Product(props)  {
  const navigate=useNavigate();
  const  handleClick=(id)=>{
    if(window.confirm("are you sure to display product."+id)){
      navigate("/display/"+id);
    }
  }
      return (
          <tr>
            <td><button className="btn btn-link" onClick={()=>handleClick(props.name)} > {props.name}</button></td>
            <td>{props.price}</td>
            <td>{props.quantity}</td>
          </tr>
      );
  }
    
