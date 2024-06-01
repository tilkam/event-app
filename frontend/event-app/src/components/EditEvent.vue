<template>
  <div id="edit-event">
    <h1>Edit Event</h1>
    <div>
      <form @submit.prevent="updateEvent">
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
      <div id="update-success" v-if="creationSuccess">Event updated successfully!</div>
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
  async mounted(){
    const response = await axios.get(`http://localhost:8080/event/${this.$route.params.id}`);
    this.name = response.data.name;
    this.description = response.data.description;
    this.location = response.data.location;
    this.startDate = response.data.startDate;
    this.endDate = response.data.endDate;
    this.startTime = response.data.startTime;
    this.endTime = response.data.endTime;
  },
  methods: {
    async updateEvent() {
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
        console.log(this.$route.params.id)
        const response = await axios.put(`http://localhost:8080/event/update/${this.$route.params.id}`, event);
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