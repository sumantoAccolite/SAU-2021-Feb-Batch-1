import React from 'react';
import './App.css'
export default function Books( props ) {

    console.log(props.match.params.name);
    return (
    <div>
        <table>
        <tbody>
        <tr><td><b>BOOK</b></td><td>{props.match.params.name}</td></tr>
        <tr><td><b>AUTHOR</b></td><td>{props.match.params.author}</td></tr>
        <tr><td><b>DESCRIPTION</b></td><td>{props.match.params.Description}</td></tr>
        </tbody>
        </table>
        <br></br>
        <br></br>
        <br></br>
    </div>    
    );
}
