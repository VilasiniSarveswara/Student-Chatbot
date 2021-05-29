import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'


Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    user_details: {},
    chat: {},
    technicalResponseTextList: [],
    technicalResponseLinkList: [],
    generalResponseLinkList: [],
    behavioralResponseTextList: [],
    behavioralResponseLinkList: [],

  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },

    //mutator to set the userDetails in the store for easy access to that information.
    SET_USER_DETAILS(state, user_details) {

      state.user_details = user_details;

    },

    SET_TECHNICAL_RESPONSE_TEXT(state, responseTechnicalTextObject) {
      state.technicalResponseTextList = responseTechnicalTextObject
    },

    SET_TECHNICAL_RESPONSE_LINKS(state, responseTechnicalLinkObject) {
      state.technicalResponseLinkList = responseTechnicalLinkObject
    },

    SET_GENERAL_RESPONSE_LINK_LIST(state, generalLinkObject) {
      state.generalResponseLinkList = generalLinkObject
    },

    SET_BEHAVIORAL_RESPONSE_TEXT(state, responseBehavioralTextObject) {
      state.behavioralResponseTextList = responseBehavioralTextObject
    },

    SET_BEHAVIORAL_RESPONSE_LINKS(state, responseBehavioralLinkObject) {
      state.behavioralResponseLinkList = responseBehavioralLinkObject
    },

    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      //needs to reset the state.userdetails as well when logging out
      axios.defaults.headers.common = {};
    },

  }
})
