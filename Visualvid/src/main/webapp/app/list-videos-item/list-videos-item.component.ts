import { Component, OnInit, AfterViewInit, Input, Inject, Optional } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
// const Plyr = require("plyr");
import { AdminMedia } from 'app/admin/admin-upload/admin-upload-form/adminmedia.model';
import { AdminMediaService } from 'app/admin/admin-upload/admin-media.service';
import { AddFaviourite } from 'app/whish-list-items/AddFaviourite';
@Component({
  selector: 'jhi-list-videos-item',
  templateUrl: './list-videos-item.component.html',
  styleUrls: ['./list-videos-item.component.scss'],
})
export class ListVideosItemComponent implements OnInit, AfterViewInit {
  // public player?: videojs.Player;
  autoplay = false;
  public player: any;
  @Input() item?: AdminMedia;
  constructor(private mediaService: AdminMediaService, @Optional() @Inject(MAT_DIALOG_DATA) data?: any) {
    if (data) {
      this.item = data.item;
      this.autoplay = data.config?.autoplay;
    }
  }

  ngOnInit(): void {}
  ngAfterViewInit(): void {
    if (this.item && this.item.id) {
      const conf = {};
      conf['userActions'] = {
        //         doubleClick: () => {
        //           if(this.player){
        //             this.player.pause()
        //           }
        //        }
      };
      // conf['autoplay'] = this.autoplay;
      //  this.player = videojs(document.getElementById(this.item.id), conf);
      //  const players = Array.from(document.querySelectorAll('.player12345')).map(p => new Plyr(p));
    }
  }

  addFaviouritMedia(item: AdminMedia): void {
    const email = localStorage.getItem('email');
    const userId = localStorage.getItem('userId');
    const faviourite = new AddFaviourite('', item.id!, item.name!, userId!, email!);
    this.mediaService.addFaviouritMedia(faviourite).subscribe(res => {});
  }
}
