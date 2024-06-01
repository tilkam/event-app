<template>
  <form @submit.prevent="submitForm">
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
</template>

<script>
export default {
  props: {
    initialData: {
      type: Object,
      default: () => ({}),
    },
  },
  data() {
    return {
      name: this.initialData.name || '',
      description: this.initialData.description || '',
      location: this.initialData.location || '',
      startDate: this.initialData.startDate || '',
      endDate: this.initialData.endDate || '',
      startTime: this.initialData.startTime || '',
      endTime: this.initialData.endTime || '',
    };
  },
  methods: {
    submitForm() {
      this.$emit('submit', {
        name: this.name,
        description: this.description,
        location: this.location,
        startDate: this.startDate,
        endDate: this.endDate,
        startTime: this.startTime,
        endTime: this.endTime,
      });
      this.resetForm();
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
  watch: {
    initialData(newData) {
      this.name = newData.name || '';
      this.description = newData.description || '';
      this.location = newData.location || '';
      this.startDate = newData.startDate || '';
      this.endDate = newData.endDate || '';
      this.startTime = newData.startTime || '';
      this.endTime = newData.endTime || '';
    },
  },
};
</script>