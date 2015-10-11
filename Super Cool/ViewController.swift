//
//  ViewController.swift
//  Super Cool
//
//  Created by Jermaine Lorenzo Goins on 10/8/15.
//  Copyright © 2015 Jermaine Lorenzo Goins. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var makeMeUncool: UIButton!
    @IBOutlet weak var logo: UIImageView!
    @IBOutlet weak var background: UIImageView!
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func makeMeUncool(sender: AnyObject) {
        
        makeMeUncool.hidden = false
        logo.hidden = false
        background.hidden = false
    }

}

