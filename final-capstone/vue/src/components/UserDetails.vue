<template>
  <div>

  </div>
</template>

<script>
import AuthService from '../services/AuthService.js'
export default {
    name: "userdetails",
    data() {
        return {
            user: {

            }
        }
    },
    created () {
        const username = this.$route.params.username
        AuthService.getUserDetails(username).then(response => {
            this.user= response.data
        }) 
    }


}
</script>

<style>

</style>