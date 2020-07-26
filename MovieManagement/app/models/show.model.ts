
export class Show {
  id:number;
  price: string;
  sTime: string;
  eTime: string;
  showTime: string;
  userid: string;
  constructor(sTime: string, eTime: string, price: string) {
    this.price = price;
    this.sTime = sTime;
    this.eTime = eTime;
  }

}
