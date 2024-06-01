<template>
  <div id="create-event">
    <h1>Create Event</h1>
    <div>
      <EventForm @submit="createEvent"/>
      <div id="create-success" v-if="creationSuccess">Event created successfully!</div>
    </div>
  </div>
</template>
<script>

import axios from 'axios';
import EventForm from "@/components/EventForm.vue";

export default {
  components: {EventForm},
  data() {
    return {
      name: '',
      description: '',
      location: '',
      startDate: '',
      endDate: '',
      startTime: '',
      endTime: '',
      creationSuccess: false,
    };
  },
  methods: {
    async createEvent(event) {
      try {
        const response = await axios.post('http://localhost:8080/event/create', event);
        console.log(response.data);
        if (response.status === 200) {
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

#create-event {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  padding: 3rem;
}
#create-success {
  text-align: center;
  background-color: #93c495;
  padding: 3rem;
  margin: 2rem;
  border-radius: 1rem;
}
</style>