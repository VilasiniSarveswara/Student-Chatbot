import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },
  getUserDetails(username) {
    return axios.get(`/userdetails/${username}`)
  },

  getPathwayDetails(topic) {
    return axios.get(`/pathway/${topic}`)
  },

  updateUserAccountDetails(user) {
    return axios.put('/updateUserDetails', user)
  },

  getQuotes() {
    return axios.get('/getQuotes')
  },
  getWeather(zipCode) {
    return axios.get(`/weather/${zipCode}`)
  }
}
