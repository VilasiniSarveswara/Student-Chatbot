<template>
  <div class="home">
    <h1>Home</h1>
    <button>My Account</button>
    <p>Welcome, {{ Tamla }} Student</p>
    <nav class="navigation">
      <ul>
        <li id="nav-button">
          <router-link> Help related to Pathway</router-link>
        </li>
        <li id="nav-button">
          <router-link> Help related to curriculum </router-link>
        </li>
        <li id="nav-button">
          <router-link> Get motivational quotes </router-link>
        </li>
        <li id="nav-button">
          <router-link> Open Positions </router-link>
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
