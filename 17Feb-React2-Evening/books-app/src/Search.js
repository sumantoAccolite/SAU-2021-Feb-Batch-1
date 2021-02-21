import React, { useState, useRef, useEffect } from 'react';
export default function Search({ books }) {
    let searchText = useRef();
    const [results, setResults] = useState([]);
    function check() {
        let name =""; 
        name = searchText.current.value;
        if (name === undefined || name.length === 0)
        {
            setResults("");
            return ;
        }
        let x = [];
        books.forEach((item) => {
            if (item.name.includes(name))
                x.push(item.name);
        })
        let results1 = "";
        x.forEach((item) => {
            results1 += item;
            results1 += ",";
        })
        setResults(results1);
    }
    useEffect(() => {
        setResults("");
    }, []);
    return (
        <div>
            <input onChange={check} ref={searchText} type="text" />
            
            <h3>Search Results:</h3>{results}
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            List Of Books:
        </div>
    );
}
