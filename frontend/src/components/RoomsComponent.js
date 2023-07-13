import React from 'react';
import RoomsService from '../services/RoomsService';

class RoomsComponent extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            rooms: []
        }
    }

    componentDidMount() {
        RoomsService.getRooms().then((response) => {
            this.setState({rooms: response.data})
        })
    }

    render() {
        return (
            <div>
                <h1 className = "text-center">Available Rooms</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td>Room Number</td>
                            <td>Floor</td>
                            <td>Number of Beds</td>
                            <td>Nightly Rate</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.rooms.map(
                                room =>
                                <tr key = {room.id}>
                                    <td>{room.number}</td>
                                    <td>{room.floor}</td>
                                    <td>{room.beds}</td>
                                    <td>{'$' + room.rate}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default RoomsComponent;