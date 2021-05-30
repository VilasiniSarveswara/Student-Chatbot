<template>
  <div>
    <div id="nav" class="head-wrapper">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <h1>My Account</h1>
    <div class="accountdetails">
      <label class="un" for="username" id="first-input">Username:</label>
      <label id="username" class="un">{{
        this.$store.state.user.username
      }}</label>

      <label for="firstname" class="fn">Firstname:</label>
      <h3 id="firstname" class="fn">
        {{ this.$store.state.user_details.firstName }}
      </h3>

      <label for="lastname" class="ln">Lastname:</label>
      <h3 id="lastname" class="ln">
        {{ this.$store.state.user_details.lastName }}
      </h3>
      <label for="emailId" class="email">Email Id:</label>
      <h3 id="emailId" class="email">
        {{ this.$store.state.user_details.emailId }}
      </h3>
      <label for="contactnumber" class="contact">Contact Number:</label>
      <h3 id="contactnumber" class="contact">
        {{ this.$store.state.user_details.contactNumber }}
      </h3>
      <a href="#" v-on:click="showForm = true" v-if="showForm === false"
        >Show Update Form</a
      >
    </div>

    <div class="update-form-wrapper">
      <form class="update" v-on:submit.prevent="" v-if="showForm === true">
        <label for="username" id="first-input">Username</label>
        <input type="text" v-model="this.$store.state.user.username" /> <br />
        <label for="firstname">Firstname</label>
        <input type="text" v-model="this.$store.state.user_details.firstName" />
        <br />
        <label for="lastname">Lastame</label>

        <input type="text" v-model="this.$store.state.user_details.lastName" />
        <br />
        <label for="emailId">Email Id</label>
        <input type="text" v-model="this.$store.state.user_details.emailId" />
        <br />
        <label for="contactnumber">Contact Number</label>
        <input
          type="text"
          v-model="this.$store.state.user_details.contactNumber"
        />
        <br />
        <label for="checkbox">Student (leave unchecked if alumni)</label>
        <input
          type="checkbox"
          v-model="this.$store.state.user_details.isStudent"
        />

        <button>Update</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "my-account",
  user: {
    username: "",
  },
  data() {
    return {
      showForm: false,
    };
  },
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

h1 {
  color: #221717;
}
label {
  font-size: 22px;
  color: #221717;
  font-family: "Oswald", sans-serif;
  margin-top: 1%;
}
.un,
.fn,
.ln,
.email,
.contact {
  text-transform: capitalize;
  font-size: 22px;
  color: #221717;
  font-family: "Oswald", sans-serif;
  padding: 10px;
  margin: 0;
  width: 200px;
}

.accountdetails {
  display: grid;
  grid-template-columns: 1fr 8fr;
  grid-template-areas:
    "ga-username ga-username-value "
    "ga-firstname ga-firstname-value"
    "ga-lastname ga-lastname-value"
    "ga-email ga-email-value"
    "ga-contact ga-contact-value";
  padding: 20px;
  margin-top: 8px;
  margin-left: 30px;
  margin-right: 60%;
}

.update-form-wrapper {
  padding-bottom: 15px;
  margin-right: 60%;
  margin-left: 35px;
}

.first-input {
  grid-area: ga-username;
}
#username {
  grid-area: ga-username-value;
}

.fn {
  grid-area: ga-firstname;
}
#firstname {
  grid-area: ga-firstname-value;
}

.ln {
  grid-area: ga-lastname;
}

#lastname {
  grid-area: ga-lastname-value;
}

#emailId {
  grid-area: ga-email-value;
}
.email {
  grid-area: ga-email;
}
#contactnumber {
  grid-area: ga-contact-value;
}
.contact {
  grid-area: ga-contact;
}
#nav > a {
  font-family: "Poppins", sans-serif;
  font-size: 35px;
  text-decoration: none;
  color: #caf0f8;
  margin-top: 25px;
  margin-bottom: 20px;
  padding: 8px 20px 5px 20px;
  background-image: linear-gradient(to bottom left, #168aad, #1a759f, #1e6091);
  border-radius: 8px;
  transition: ease-out 0.8s;
}

#nav > a:hover {
  text-decoration: underline;
  font-size: 37px;
  color: #343a40;
  background-image: linear-gradient(to bottom left, #34a0a4, #52b69a);
}
#nav {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  width: 70%;
}
.head-wrapper {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  width: 100%;
}
a {
  font-family: "Poppins", sans-serif;
  font-size: 35px;
  text-decoration: none;
  color: #caf0f8;
  margin-top: 25px;
  margin-bottom: 20px;
  padding: 8px 20px 5px 20px;
  background-image: linear-gradient(to bottom left, #168aad, #1a759f, #1e6091);
  border-radius: 8px;
  transition: ease-out 0.8s;
  width: 360px;
  height: 60px;
}
a:hover {
  text-decoration: underline;
  font-size: 37px;
  color: #343a40;
  background-image: linear-gradient(to bottom left, #34a0a4, #52b69a);
}
</style>