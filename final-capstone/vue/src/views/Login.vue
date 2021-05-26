<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Login</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering, please sign in.
      </div>

      <label for="username" id="first-input" class="sr-only">Username:</label>

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
      <label for="password" class="sr-only">Password: </label>

      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <br />
      <button type="submit">Sign in</button>

      <router-link :to="{ name: 'register' }">Need an account?</router-link>
    </form>
  </div>
</template>

<script>
import AuthService from "../services/AuthService";
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);

            AuthService.getUserDetails(this.user.username).then((response) => {
              console.log(response.data);

              const user_details = response.data;

              this.$store.commit("SET_USER_DETAILS", user_details);

              this.$router.push("/");
            });
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>
<style scoped>
form {
  margin-left: 3.5%;
  margin-top: 3%;
}
h1 {
  margin: 0;
}

label {
  font-size: 22px;
  color: #caf0f8;
  font-family: "Oswald", sans-serif;
  margin-top: 1%;
}
input {
  margin-left: 0.5%;
  margin-top: 2%;
}

#first-input {
  margin-top: 0%;
}

a {
  margin-top: 2%;
  margin-left: 35px;
  font-size: 22px;
  font-family: "Oswald", sans-serif;
  color: #caf0f8;
}
a:hover {
  color: #48cae4;
}
button {
  margin-top: 2%;
  font-family: "Oswald", sans-serif;
  font-size: 18px;
}

.alert {
  font-size: 40px;
  color: #caf0f8;
  font-family: "Oswald", sans-serif;
}
</style>
