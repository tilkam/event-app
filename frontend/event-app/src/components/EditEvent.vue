<template>
  <div id="edit-event">
    <h1>Edit Event</h1>
    <div>
      <EventForm :initialData="event" @submit="updateEvent"/>
      <div id="update-success" v-if="creationSuccess">Event updated successfully!</div>
    </div>
  </div>
</template>

<script>
import {useRoute} from "vue-router";
import EventForm from "@/components/EventForm.vue";
import axios from 'axios';
export default {
  components: {EventForm},
  data() {
    return {
      event: {},
      creationSuccess: false,
    };
  },
  async mounted(){
    const route = useRoute();
    console.log(route.params.id);
    const response = await axios.get(`http://localhost:8080/event/${route.params.id}`);
    this.event = response.data;
  },
  methods: {
    async updateEvent(event) {
      try {
      console.log(event);
        const response = await axios.put(`http://localhost:8080/event/update/${event.id}`, event);
        console.log(response.data);
        if(response.status === 200) {
          this.creationSuccess = true;
        }
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>

<style>
form {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

#edit-event {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  padding: 3rem;
}
#update-success {
  text-align: center;
  background-color: #93c495;
  padding: 3rem;
  margin: 2rem;
  border-radius: 1rem;
}
</style>