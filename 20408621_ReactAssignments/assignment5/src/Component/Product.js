import React from "react";
import {useNavigate } from "react-router-dom";


export default function Product(props)  {
      return (
          <tr>
            <td> {props.name}</td>
            <td>{props.price}</td>
            <td>{props.quantity}</td>
          </tr>
      );
      }
    
