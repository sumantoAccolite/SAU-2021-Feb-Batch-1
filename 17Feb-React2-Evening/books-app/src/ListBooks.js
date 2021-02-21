import React from 'react';
import { Link } from 'react-router-dom';

export default function ListBooks({ books }) {
    return (
        books.map(item => {
            return <Link key= {item.name} to={{pathname :"/"+item.name+"/"+item.Description+"/"+item.author}}><li>
                {item.name}
                </li></Link>
        })
    );
}
