<template>
  <div id="create-event">
    <h1>Create Event</h1>
    <div>
      <form @submit.prevent="createEvent">
        <label for="name">Name</label>
        <input type="text" id="name" v-model="name" required>
        <label for="description">Description</label>
        <textarea id="description" v-model="description" required></textarea>
        <label for="startDate">Start Date</label>
        <input type="date" id="date" v-model="startDate" required>
        <label for="endDate">End Date</label>
        <input type="date" id="endDate" v-model="endDate" required>
        <button type="submit">Create</button>
      </form>
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
      startDate: '',
      endDate: '',
    };
  },
  methods: {
    async createEvent() {
      const event = {
        name: this.name,
        description: this.description,
        startDate: this.startDate,
        endDate: this.endDate,
      };

      try {
        const response = await axios.post('http://localhost:8080/event/create', event);
        console.log(response.data);
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
</style>