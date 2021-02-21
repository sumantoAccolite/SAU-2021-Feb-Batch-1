import React, { useState, useRef, useEffect } from 'react';
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import ListBooks from './ListBooks';
import Book from './Book';
import Search from './Search'
function App() {
  const [books,setBooks] = useState([]);
  useEffect(() => {
    const temp=
    [
      {
        name: "Designing Data-Intensive Applications",
        author: "Martin Kleppmann",
        Description : "Book on System Design"
      },
      {
        name: "The Competetive Programming HandBook",
        author: "Anitti Laaksonen",
        Description : "Book on Competetive Programming on C++"
      },
      {
        name: "Cracking the Coding Interview",
        author: "gayle laakmann mcdowell",
        Description : "Preparing for coding interviews of big-tech companies"
      }
    ];
    setBooks(temp);
  }, []);

  return (
    <div>
      <Router>
  <Search books={books}/>
  <Route path= {'/:name/:Description/:author'} exact  component={Book} />
  <ListBooks books={books} />
  </Router>
  </div>
  );

}

export default App;