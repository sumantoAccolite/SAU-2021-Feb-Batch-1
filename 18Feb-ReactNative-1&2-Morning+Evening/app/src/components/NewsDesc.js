import React, { useEffect, useState } from 'react';
import AsyncStorage from '@react-native-community/async-storage';
import { Button,View,TextInput, Text, SafeAreaView, Platform, StyleSheet, ActivityIndicator, FlatList } from 'react-native';

const LOCAL_STORAGE_KEY = 'Assignment.todos';
const NewsDesc = (props) => {

    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [todos, setTodos] = useState([]);
    
    useEffect(() => {
        let storedTodos;
        if(localStorage.getItem(LOCAL_STORAGE_KEY+localStorage.getItem("username")))
        storedTodos = JSON.parse(
          localStorage.getItem(LOCAL_STORAGE_KEY+localStorage.getItem("username"))
        );
        if (storedTodos)
        setTodos(storedTodos);
      }, []);
    
    const addItem = async () => {
        const temp=[{
            title:title,
            description:description
        },...todos];
       await AsyncStorage.setItem(LOCAL_STORAGE_KEY+localStorage.getItem("username"), JSON.stringify(temp));
        props.navigation.goBack();
    }

    return (
        <View style={Styles.container}>
            <TextInput style={Styles.textInputStyle} onChangeText={(text) => setTitle(text)} placeholder="Title" />
            <TextInput style={Styles.textInputStyle} onChangeText={(description) => setDescription(description)} placeholder="Description" />
            <Button title="Add Note" onPress={addItem} />
        </View>
    );
}
const Styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        alignItems: "center"
    },
    loginTextStyle: {
        fontSize: 25,
        fontWeight: "700",
        marginVertical: 20
    },
    textInputStyle: {
        borderColor: "black",
        borderWidth: 1,
        borderRadius: 5,
        fontSize: 20,
        padding: 5,
        width: "60%",
        marginBottom: 20
    }
})

export default NewsDesc;