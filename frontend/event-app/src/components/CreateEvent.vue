<template>
  <div id="create-event">
    <h1>Create Event</h1>
    <div>
      <form @submit.prevent="createEvent">
        <label for="name">Name</label>
        <input type="text" id="name" v-model="name" required>
        <label for="description">Description</label>
        <textarea id="description" v-model="description"></textarea>
        <label for="location">Location</label>
        <input type="text" id="location" v-model="location" >
        <label for="startDate">Start Date</label>
        <input type="date" id="date" v-model="startDate" required>
        <label for="startTime">Start Time</label>
        <input type="time" id="startTime" v-model="startTime" required>
        <label for="endDate">End Date</label>
        <input type="date" id="endDate" v-model="endDate">
        <label for="endTime">End Time</label>
        <input type="time" id="endTime" v-model="endTime">
        <button type="submit">Save</button>
      </form>
      <div id="create-success" v-if="creationSuccess">Event created successfully!</div>
    </div>
  </div>
</template>
<script>

import axios from 'axios';

export default {
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
    async createEvent() {
      const event = {
        name: this.name,
        description: this.description,
        location: this.location,
        startDate: this.startDate,
        endDate: this.endDate,
        startTime: this.startTime,
        endTime: this.endTime,
      };

      try {
        const response = await axios.post('http://localhost:8080/event/create', event);
        console.log(response.data);
        if(response.status === 200) {
          this.creationSuccess = true;
          this.resetForm();
        }

      } catch (error) {
        console.error(error);
      }
    },
    resetForm() {
      this.name = '';
      this.description = '';
      this.location = '';
      this.startDate = '';
      this.endDate = '';
      this.startTime = '';
      this.endTime = '';
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