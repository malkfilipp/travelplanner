export interface City {
  id: number;
  name: string;
  country: {
    id: string,
    name: string
  };
  timezone: string;
  summerShift: boolean;
}
