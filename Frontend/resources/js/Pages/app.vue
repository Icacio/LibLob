<script setup>
// Imports
import { ref } from 'vue'
import { onUnmounted } from 'vue'

const book = ref({
  title: '',
  author: ''
})
const submitForm = async () => {
    const response = await fetch('http://localhost:8080/api/books', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(book.value)
    })

    if (!response.ok) {
      console.error('Errore:', error)
    }

    const data = await response.json()
    errorMessage.value = 'libro creado';
    
    // Reset form
    book.value = {
      title: '',
      author: ''
    }
  
}
</script>

<template>
  <div class="container">
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="title">Título:</label>
        <input 
          type="text" 
          id="title" 
          v-model="book.title" 
          required 
          placeholder="Inserta el título del libro"
        >
      </div>

      <div class="form-group">
        <label for="author">Autor:</label>
        <input 
          type="text" 
          id="author" 
          v-model="book.author" 
          required 
          placeholder="Inserta el autor del libro"
        >
      </div>
      <button type="submit">Salva Libro</button>
      <div>
        {{ errorMessage }}
      </div>
    </form>
  </div>
</template>

<style scoped>
.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

h1 {
  color: #2c3e50;
}

button {
  padding: 8px 16px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #3aa876;
}
</style>