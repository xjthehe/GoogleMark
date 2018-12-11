package com.pax.rowen.googlemark.ui.Fragment;

import java.util.HashMap;

/**
 * 生产fragemnt 工厂
 */
public class FragmentFactory {
    private static HashMap<Integer,BaseFragment> myFragmentMap=new HashMap<>();
    public static BaseFragment creatFragment(int pos){
        //先从集合取出，如果没有，才能创建对象 ，提高性能
        BaseFragment fragment=myFragmentMap.get(pos);
        if(fragment==null){
            switch (pos){
                case 0:
                    fragment=new HomeFragment();
                    break;
                case 1:
                    fragment=new AppFragment();
                    break;
                case 2:
                    fragment=new GameFragment();
                    break;
                case 3:
                    fragment=new SubjectFragment();
                    break;
                case 4:
                    fragment=new RecommendFragment();
                    break;
                case 5:
                    fragment=new CategoryFragment();
                    break;
                case 6:
                    fragment=new HomeFragment();
                    break;
                default:
                    break;
            }
        }
        myFragmentMap.put(pos,fragment);
        return fragment;
    }

}
