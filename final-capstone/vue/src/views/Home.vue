<template>
  <div class="home">
    <h1>Home</h1>
    <button>My Account</button>
    <p>Welcome, {{ this.$store.state.user_details.firstName}} Student</p>
    <nav class="navigation">
      <ul>
        <li id="nav-button">
          <router-link v-bind:to='{name: "pathway"}'> Help related to Pathway</router-link>
        </li>
        <li id="nav-button">
          <router-link v-bind:to='{name: "curriculum"}'> Help related to curriculum </router-link>
        </li>
        <li id="nav-button">
          <router-link v-bind:to=' {name: "quotes"}'> Get motivational quotes </router-link>
        </li>
        <li id="nav-button">
          <router-link v-bind:to='{name: "positions"}'> Open Positions </router-link>
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>
