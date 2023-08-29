import React from "react";
import { withFormik, Form, Field } from "formik";
import * as Yup from "yup";
import axios from "axios";
import { NavLink } from "react-router-dom";

const AddProduct = ({ errors, touched, isSubmitting }) => {
	return (
		<div style={{ width: "50%", margin: "auto" }}>
			<h1>Add Product</h1>
			<Form>
				<div className="form-field">
					<Field
						type="text"
						name="productName"
						placeholder="Product Name"
					></Field>
					<p className="field-error" style={{color:"red"}}>
						{errors.productName && touched.productName
							? errors.productName
							: null}
					</p>
				</div>
				<div className="form-field">
					<Field type="number" name="productQuantity" placeholder="Quantity"></Field>
					<p className="field-error" style={{color:"red"}}>
						{errors.productQuantity && touched.productQuantity ? errors.productQuantity : null}
					</p>
				</div>
				<div className="form-field">
					<Field type="text" name="productPrice" placeholder="Price "></Field>
					<span>
					<p className="field-error" style={{color:"red"}}>
						{errors.productPrice && touched.productPrice ? errors.productPrice : null}
					</p></span>
				</div>
				<div className="buttons">
					<button type="submit" className="btn btn-success">
						Add
					</button>
					<NavLink to="/" className="back">
						Back
					</NavLink>
				</div>
			</Form>
		</div>
	);
};
const AddProductForm = withFormik({
	// for initialization the form if the props is null the set the empty value
	mapPropsToValues({ productName, productQuantity, productPrice }) {
		return {
			productName: productName || "",
			productQuantity: productQuantity || "",
			productPrice: productPrice || "",
		};
	},
	validationSchema: Yup.object().shape({
		productName: Yup.string()
			.min(3, "*Name must be greater than 3 letters")
			.required("*Product name is required")
			.max(20, "*Less than 20 chars"),
		productQuantity: Yup.number().required("*Quantity should not be empty.").min(1,"*quantity should not be less than 1"),
		productPrice: Yup.number().required("*Price Should not be empty").min(1,"*price should not be less than 1"),
	}),
	handleSubmit(values, { props, resetForm, setSubmitting, setErrors, se }) {
		const postData = async() => {
			try {
				await axios.post(
					"http://localhost:3001/productData",
					values
			)
					alert("inserted Successfully...")
				resetForm();
			} catch (error) {
				setErrors(error);
			}
		};
		postData();
	},
})(AddProduct);
export default AddProductForm;
