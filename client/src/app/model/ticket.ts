export interface Ticket {
  id: number;
  schedule: {
    id: number,
    flight: {
      id: number,
      airline: {
        id: number,
        name: string,
        country: {
          id: string,
          name: string
        }
      },
      number: string,
      aircraft: {
        id: number,
        name: string
      },
      departureAirport: {
        id: string,
        name: string,
        city: {
          id: number,
          name: string,
          country: {
            id: string,
            name: string
          },
          timezone: string,
          summerShift: boolean
        }
      },
      arrivalAirport: {
        id: string,
        name: string,
        city: {
          id: number,
          name: string,
          country: {
            id: string,
            name: string
          },
          timezone: string,
          summerShift: boolean
        }
      }
    },
    departureTime: string,
    arrivalTime: string
  };
  travelClass: string;
  amount: number;
  quantity: number;
}
