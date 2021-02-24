import React from "react";
import { Button, View, Text, ImageBackground, TouchableOpacity, StyleSheet } from "react-native";
import Icon from 'react-native-vector-icons/FontAwesome';

const NewsCard = (props) => {
    const { data, navigation,deleteItem } = props;
    function DELETE(){
        console.log(data.title);
        deleteItem(data.title);
    }
    return (
        <TouchableOpacity style={Styles.container} >
            <ImageBackground style={Styles.background} imageStyle={{ borderRadius: 10 }}>
                <Text style={Styles.title}>{data.title}</Text>
                <Text style={Styles.source}>{data.description}</Text>
                <View style={Styles.xxx} >
                <Button style={Styles.xxx} title="Delete" onPress={DELETE} />
                </View>
            </ImageBackground>
        </TouchableOpacity>
    );
}

const Styles = StyleSheet.create({
    title: {
        fontSize: 16,
        color: "Black",
        fontWeight: "700"
    },
    source: {
        fontSize: 14,
        color: "Black",
        fontWeight: "200",
        padding: 5
    },
    background: {
        width: "100%",
        height: "100%",
        justifyContent: "space-between"
    },
    container: {
        width: "95%",
        height: 100,
        marginLeft: "2.5%",
        marginRight: "2.5%",
        marginVertical: 5
    },
    xxx: {
        flexDirection: 'row', justifyContent: 'flex-end'
    }

})

export default NewsCard;