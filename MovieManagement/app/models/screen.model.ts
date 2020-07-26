import { Show } from './show.model';

export class Screen {
  id: number;
  capacity: number;
  name: string;
  availability: number;
  showList: Array<Show>;
  userid: string;
  constructor(name: string, capacity: number, availability: number) {
    this.name = name;
    this.availability = availability;
    this.capacity = capacity;
  }

  
}
