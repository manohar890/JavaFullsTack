import axios from "axios";
import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

// function Display(){
//     let {name}=useParams();
//     let [da,setDa]=useState([]);
//     const fetchData = async () => {
//        await fetch("http://localhost:3001/productData?productName="+name.trim())
//           .then(response => {
//             return response.json()
//           })
//           .then(data => {
//             setDa(data)
//           })
//       }
    
// useEffect (  ()=>{
//    fetchData()
//      },[]);
// return(
//     <div style={{marginLeft:300,marginTop:20}}>
//        < h1>Details Of {name}:</h1>
       
//     <table>
//         <thead>
//             <tr>
//                 <th>Product Name</th>
//                 <th>Product Price</th>
//                 <th>Product Quantity</th>
//             </tr>
//         </thead>
//         <tbody>
//         {da.map(res=>(
//         <tr >
//             <td>{res.productName}</td>
//             <td>{res.productPrice}</td>
//             <td>{res.productQuantity}</td>
//         </tr>
//          ) )}
// </tbody>
//     </table>
//     </div>
// );
// }
function Display(){
    let {name}=useParams();
    return(
        <div style={{marginLeft:300,marginTop:20}}>
            <h1>Product Name : {name} </h1>
            <Link to={'/'}>Back</Link>
        </div>
        
    );
}

export default Display;