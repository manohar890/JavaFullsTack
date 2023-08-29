import React from 'react';
import './App.css';

class App extends React.Component{
  constructor(props){
    super(props);
    this.state={
      num:2
    };
    //this.incrementButton=this.incrementButton.bind(this);
  }
incrementButton(){
  
this.setState((prevState) => ({ 
  num: prevState.num + 1 
}));
  }
  decrementButton(){
    this.setState({num:this.state.num-1});
  }
render(){
  return(
    <div align="center" color='black'>
      <h1> Demo Counter</h1>
      <h2>Counter :</h2><h3>{this.state.num}</h3> <button onClick={()=>this.incrementButton()}>incrementButton</button>
     <button onClick={()=>this.decrementButton()}>decrementButton</button>
    </div>
  )

}
}

export default App;
