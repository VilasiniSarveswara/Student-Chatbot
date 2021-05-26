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
      <h6>
        <label for="username" class="sr-only">Username</label>
      </h6>

      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <h6>
        <label for="password" class="sr-only">Password</label>
      </h6>

      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <h6>
        <button type="submit">Sign in</button>
      </h6>

      <h6>
        <router-link :to="{ name: 'register' }">Need an account?</router-link>
      </h6>
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
h6 {
  font-size: 20px;
  color: #caf0f8;
  margin: 0%;
  margin-left: 3%;
  font-family: "Oswald", sans-serif;
}
form {
  margin-left: 3%;
}
label,
input {
  margin-bottom: 1%;
}
h1 {
  color: #caf0f8;
  margin-left: 0.5%;
}
</style>
