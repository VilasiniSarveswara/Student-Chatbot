<template>
  <div>
    <h1>My Account</h1>
   <form><label for="username" id="first-input" >Username</label> 
  <input type="text" v-model="this.$store.state.user.username"/> <br>
  <label for="firstname">Firstname</label>
      <input type="text" v-model="this.$store.state.user_details.firstName"> <br>
        <label for="lastname">Lastame</label>


    <input type="text" v-model="this.$store.state.user_details.lastName"> <br>
        <label for="emailId">Email Id</label>
      <input type="text" v-model="this.$store.state.user_details.emailId">
       <br> <label for="contactnumber">Contact Number</label> 
      <input type="text" v-model="this.$store.state.user_details.contactNumber"> <br>
        <label for="checkbox">Student (leave unchecked if alumni)</label> 
      <input type="checkbox" v-model="this.$store.state.user_details.isStudent">

   <button>
     Update</button></form> 
  </div>
</template>

<script>
export default {
  name: "my-account",
  user: {
    username: ""
  }
};
</script>

<style>
form {
  margin-left: 3.5%;
  margin-top: 3%;
}

input {
  margin-left: 0.5%;
  margin-top: 2%;
}
label {
  font-size: 22px;
  color: #caf0f8;
  font-family: "Oswald", sans-serif;
  margin-top: 1%;
}
</style>