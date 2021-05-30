<template>
  <div id="register" class="text-center">
    <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
    <form class="form-register" @submit.prevent="register">
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <br />

      <label for="first-name">First Name</label>
      <input
        type="text"
        id="firstName"
        class="form-control"
        v-model="user.firstName"
        required
      />
      <br />

      <label for="last-name">Last Name</label>
      <input
        type="text"
        id="lastName"
        class="form-control"
        v-model="user.lastName"
        required
      />
      <br />

      <label for="emailId">Email</label>
      <input
        type="text"
        id="email"
        class="form-control"
        v-model="user.emailId"
        required
      />
      <br />

      <label for="contact-number">Phone Number</label>
      <input
        type="number"
        id="contact-number"
        class="form-control"
        v-model="user.contactNumber"
        required
      />

      <!-- TODO need to find how the radio ties into our information to relay that to the database -->
      <br />
      <label for="userIsStudent">Student </label>
      <input
        type="checkbox"
        id="isStudent"
        v-model="user.isStudent"
        :checked="true"
      />
      <br />

      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <br />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
        firstName: "",
        lastName: "",
        emailId: "",
        contactNumber: 0,
        isStudent: false,
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
form {
  margin-left: 3.5%;
}

input {
  background-color: #f8f9fa;
  width: 200px;
  height: 20px;
  padding-left: 5px;
}
</style>
