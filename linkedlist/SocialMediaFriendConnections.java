package com.bridgelabz.linkedlist;

import java.util.ArrayList;

class Friend{
    String userId;
    String name;
    int age;
    ArrayList<String> friendIds;
    Friend next;
    Friend(String userId, String name, int age){
        this.userId=userId;
        this.name=name;
        this.age=age;
        friendIds=new ArrayList<String>();
        this.next=null;
    }
}
public class SocialMediaFriendConnections {
    static Friend head;
    static Friend tail;
    public static void addUser(String userId, String name, int age){
        Friend newNode=new Friend(userId, name, age);
        if(head==null){
            head=newNode;
            tail=head;
        }
        else{
            tail.next=newNode;
            tail=newNode;
            tail.next=null;
        }
    }
    public static Friend findUser(String userId){
        Friend current=head;
        while(current!=null){
            if(current.userId.equals(userId)){
                return current;
            }
            current=current.next;
        }
        return null;
    }
    public static void addFriend(String userId, String friendId){
        Friend userOne=findUser(userId);
        Friend userTwo=findUser(friendId);
        if(userOne==null || userTwo==null){
            System.out.println("Invalid");
            return;
        }
        userOne.friendIds.add(friendId);
        userTwo.friendIds.add(userId);
    }
    public static void removeFriend(String userId, String friendId){
        Friend userOne=findUser(userId);
        Friend userTwo=findUser(friendId);
        if(userOne==null || userTwo==null){
            System.out.println("Invalid");
            return;
        }
        userOne.friendIds.remove(friendId);
        userTwo.friendIds.remove(userId);
    }
    public static void mutualConnections(String userOneId,String userTwoId){
        Friend userOne=findUser(userOneId);
        Friend userTwo=findUser(userTwoId);
        if(userOne==null || userTwo==null){
            System.out.println("Invalid");
            return;
        }
        ArrayList<String> userOneFriends=userOne.friendIds;
        ArrayList<String> userTwoFriends=userTwo.friendIds;
        for (String userOneFriend : userOneFriends) {
            for (String userTwoFriend : userTwoFriends) {
                if (userOneFriend.equals(userTwoFriend)) {
                    Friend friend=findUser(userOneFriend);
                    System.out.println("Mutual connections of "+userOneId+" and "+userTwoId+" are");
                    System.out.println("[" + friend.userId + "," + friend.name + "," + friend.age + "]");
                }
            }
        }
    }
    public static void displayFriends(String userId){
        Friend current=findUser(userId);
        if(current==null){
            System.out.println("Invalid");
            return;
        }
        if(current.friendIds.isEmpty()){
            System.out.println("No friends");
            return;
        }
        System.out.println("Friends of "+userId+" are:");
        for(String friendId:current.friendIds){
            Friend friend=findUser(friendId);
            System.out.println("["+friendId+","+friend.name+","+friend.age+"]");
        }
    }
    public static void searchUser(String userId){
        Friend current=findUser(userId);
        if(current==null){
            System.out.println("Invalid");
            return;
        }
        System.out.println("User details of id: "+userId+" are: ");
        System.out.println("["+current.userId+","+current.name+","+current.age+"]");
    }
    public static void countFriends(String userId){
        Friend current=findUser(userId);
        if(current==null){
            System.out.println("Invalid");
            return;
        }
        System.out.println("Number of friends of "+userId+" are: "+current.friendIds.size());
    }
    public static void main(String[] args) {
        addUser("1", "vamsi", 20);
        addUser("2", "pranav", 24);
        addUser("3", "sachin", 22);
        addUser("4", "rahul", 23);
        addFriend("1", "3");
        addFriend("1", "4");
        addFriend("1", "2");
        addFriend("3", "4");
        addFriend("4", "2");
        countFriends("1");
        searchUser("1");
        removeFriend("1", "3");
        mutualConnections("1", "4");
        displayFriends("1");
    }
}