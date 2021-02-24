import React, { useEffect, useState } from 'react';
import AsyncStorage from '@react-native-community/async-storage';
import { Image, Button, View, Text, SafeAreaView, Platform, StyleSheet, FlatList } from 'react-native';

import NewsCard from "./NewsCard";
import NewsDesc from "./NewsDesc";
const LOCAL_STORAGE_KEY = 'Assignment.todos';

export default function Dashboard(props) {
    //console.log("dashboard props", props); 

    const [items, setItems] = useState([]);
    useEffect(() => {
        const unsubscribe = props.navigation.addListener('focus', () => {
            console.log('Refreshed!');
            let storedTodos = [];
            if (localStorage.getItem(LOCAL_STORAGE_KEY+localStorage.getItem("username")))
                storedTodos = JSON.parse(
                    localStorage.getItem(LOCAL_STORAGE_KEY+localStorage.getItem("username"))
                );
            if (storedTodos)
                setItems(storedTodos);
        });
        return unsubscribe;
    }, [props.navigation]);
    const deleteItem = async (title) => {
        const temp = items.filter(item => item.title != title);
        console.log(temp);
        await AsyncStorage.setItem(LOCAL_STORAGE_KEY+localStorage.getItem("username"), JSON.stringify(temp));
        renderArticles();
        setItems(temp);

    }
    const renderArticles = () => {
        const articles = items;
        if (articles.length > 0) {
            return (<FlatList
                data={articles}
                renderItem={({ item }) => <NewsCard data={item} deleteItem={deleteItem} navigation={props.navigation} />}
                keyExtractor={(item) => item.publishedAt}
                initialNumToRender={5}
            />)
        }
        return (
            <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
                <Text> No Notes Added </Text>
            </View>
        );

    }
    const jump = () => {
        props.navigation.navigate("NewsDesc");
    }

    return (
        <View>
            <View style={Styles.innerContainer}>
            <Button style={Styles.xxx} title="Add note" onPress={jump} />
            </View>
            <SafeAreaView style={Styles.mainContainer}>
                {renderArticles()}
            </SafeAreaView>
        </View>
    );
}


const Styles = StyleSheet.create({
    mainContainer: {
        marginTop: Platform.OS === 'android' ? 25 : 0
    },
    container: {
        ...StyleSheet.absoluteFillObject,
        alignSelf: 'flex-end',
        marginTop: -5,
        justifyContent: 'flex-end',
        position: 'absolute', // add if dont work with above
    },
    buttonStyle:{  
        width: "30%"
    }  ,
    innerContainer:{  
        // flex: 1,  
         width: "100%",  
         flexDirection: "row-reverse",  
         justifyContent: "space-between",  
         alignItems: "center"  ,
         alignSelf: 'flex-end',
     }, 
})
// {
//     id: Math.floor((Math.random() * 1000)).toString(),
//     text: 'Milk'
// },
// {
//     id: Math.floor((Math.random() * 1000)).toString(),
//     text: 'Chocolate'
// },
// {
//     id: Math.floor((Math.random() * 1000)).toString(),
//     text: 'Tissue Paper'
// },
// {
//     id: Math.floor((Math.random() * 1000)).toString(),
//     text: 'Toothbrush'
// },
// const fetchData = async () => {
//     const URL = "http://newsapi.org/v2/everything?q=tesla&from=2021-01-23&sortBy=publishedAt&apiKey=9a6dd9ea60ab4b0cacb7c9a5e6432192";
//     const response = await fetch(URL);
//     const data = await response.json();
//     setArticles(data.articles);
// }
