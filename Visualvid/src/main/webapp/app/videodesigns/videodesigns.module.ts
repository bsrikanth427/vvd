import { NgModule } from '@angular/core';
import { VisualvidSharedModule } from 'app/shared/shared.module';

import { VideoDesignsComponent } from './videodesigns.component';
import { VideoListingComponent } from './videolisting/videolisting.component';
import { VideoItemComponent } from './videoitem/videoitem.component';
import { ListVideosCategoryComponent } from 'app/list-videos-category/list-videos-category.component';
import { ListVideosItemComponent } from 'app/list-videos-item/list-videos-item.component';
import { WhishListItemsComponent } from 'app/whish-list-items/whish-list-items.component';
import { CartComponent } from 'app/cart/cart.component';
import { UserUploadIncompleteComponent } from 'app/user-upload-incomplete/user-upload-incomplete.component';

@NgModule({
  imports: [VisualvidSharedModule],
  declarations: [
    VideoDesignsComponent,
    VideoListingComponent,
    VideoItemComponent,
    ListVideosCategoryComponent,
    ListVideosItemComponent,
    WhishListItemsComponent,
    CartComponent,
    UserUploadIncompleteComponent,
  ],
  exports: [VideoDesignsComponent],
})
export class VideoDesignsModule {
  constructor() {}
}
