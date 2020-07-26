
export class Ticket {
  showid: number;
  movieImg: string;
  movieName: string;
  showTime: string;
  message: string;
  userid: string;
  constructor(showid: number, showTime: string, userid: string) {
    this.showid = showid;
    this.showTime = showTime;
    this.userid = userid;
  }
}
