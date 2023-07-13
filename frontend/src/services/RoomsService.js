import axios from 'axios'

const ROOMS_REST_API_URL = 'http://localhost:8080/api/v1/rooms';

class RoomsService {

    getRooms() {
        return axios.get(ROOMS_REST_API_URL);
    }
}

export default new RoomsService();